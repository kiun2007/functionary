
(function($){
    $.fn.toJson=function(){
        var serializeObj={};
        var array=this.serializeArray();
        var str=this.serialize();
        $(array).each(function(){
            if(serializeObj[this.name]){
                if($.isArray(serializeObj[this.name])){
                    serializeObj[this.name].push(this.value);
                }else{
                    serializeObj[this.name]=[serializeObj[this.name],this.value];
                }
            }else{
                serializeObj[this.name]=this.value;
            }
        });
        return serializeObj;
    };
})(jQuery);

function initEditor(id, codeValue = ''){

    var languageTools = ace.require("ace/ext/language_tools");
    var editor = ace.edit(id);
    editor.session.setMode("ace/mode/jexl");
    editor.setTheme("ace/theme/tomorrow");
    // enable autocompletion and snippets
    editor.setOptions({
        enableBasicAutocompletion: true,
        enableSnippets: true,
        enableLiveAutocompletion: true
    });

    editor.setValue(codeValue)

    editor.session.on('change', function (){
        if (!window.editorMap){
            window.editorMap = {}
        }
        window.editorMap[id] = editor.getValue()
    })

    languageTools.addCompleter({
        getCompletions: function(editor, session, pos, prefix, callback) {
            callback(null,  [
                {
                    name : "test",
                    value : "test",
                    caption: "test",
                    meta: "test",
                    type: "local",
                    score : 1000 // 让test排在最上面
                }
            ]);
        }
    });
}