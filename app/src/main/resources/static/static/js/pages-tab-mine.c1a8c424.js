(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-tab-mine"],{"0205":function(t,e,a){"use strict";a.r(e);var i=a("65cf"),n=a.n(i);for(var c in i)["default"].indexOf(c)<0&&function(t){a.d(e,t,(function(){return i[t]}))}(c);e["default"]=n.a},"0359":function(t,e,a){var i=a("24fb");e=i(!1),e.push([t.i,"/* pages/tab/mine.wxss */uni-page-body[data-v-126b7f0d]{background-color:#f0f0f0}body.?%PAGE?%[data-v-126b7f0d]{background-color:#f0f0f0}fixedcheck .check[data-v-126b7f0d]{height:12px;width:22px}",""]),t.exports=e},"110c":function(t,e,a){"use strict";a("7a82");var i=a("4ea4").default;Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var n=i(a("528a")),c=n.default.extend({data:function(){return{}},props:{title:{type:String},icon:{type:String},url:{type:String}},methods:{},created:function(){}});e.default=c},"1d9d":function(t,e,a){"use strict";a.r(e);var i=a("3628"),n=a.n(i);for(var c in i)["default"].indexOf(c)<0&&function(t){a.d(e,t,(function(){return i[t]}))}(c);e["default"]=n.a},2078:function(t,e,a){var i=a("d414");i.__esModule&&(i=i.default),"string"===typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);var n=a("4f06").default;n("b3a3823a",i,!0,{sourceMap:!1,shadowMode:!1})},2405:function(t,e,a){"use strict";var i=a("a4f0"),n=a.n(i);n.a},"338d":function(t,e,a){"use strict";a.d(e,"b",(function(){return i})),a.d(e,"c",(function(){return n})),a.d(e,"a",(function(){}));var i=function(){var t=this.$createElement,e=this._self._c||t;return e("v-uni-view",[this.checked?e("v-uni-image",{staticClass:"check",attrs:{src:this.checkicon}}):e("v-uni-image",{staticClass:"check",attrs:{src:this.icon}}),e("v-uni-text",{staticClass:"fixedcheck"},[this._t("default")],2)],1)},n=[]},"35c5":function(t,e,a){var i=a("0359");i.__esModule&&(i=i.default),"string"===typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);var n=a("4f06").default;n("7d4c4a70",i,!0,{sourceMap:!1,shadowMode:!1})},3628:function(t,e,a){"use strict";a("7a82");var i=a("4ea4").default;Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var n=i(a("c7eb")),c=i(a("1da1")),s=i(a("528a")),r=a("18eb"),u=s.default.extend({data:function(){return{isAi:!1,count:{noticeCount:"",detailsCount:"",aiCount:""}}},onShow:function(){var t=this;return(0,c.default)((0,n.default)().mark((function e(){return(0,n.default)().wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.t0=t,e.next=3,(0,r.getCollectCount)();case 3:e.t1=e.sent,e.t2={count:e.t1},e.t0.setData.call(e.t0,e.t2);case 6:case"end":return e.stop()}}),e)})))()},methods:{aiTap:function(){this.setData({isAi:!this.isAi})}}});e.default=u},"528a":function(t,e,a){"use strict";a("7a82");var i=a("4ea4").default;Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var n=i(a("5530")),c=i(a("e143")),s=a("d4e5"),r=a("4e88"),u=a("3ddc"),o=a("60b7"),d=a("7742"),l=a("4844"),f=a("dc64"),v=a("6e89"),p=a("4d9c"),h=c.default.extend((0,n.default)((0,n.default)({},s.pageLifetimes),{},{methods:{clone:r.clone,handleDataset:u.handleDataset,escape2Html:o.escape2Html,html2Escape:o.html2Escape,parseEventDynamicCode:d.parseEventDynamicCode,getTabBar:l.getTabBar,getRelationNodes:f.getRelationNodes,zpSelectComponent:v.selectComponent,zpSelectAllComponents:v.selectAllComponents,setData:p.setData}}));e.default=h},"65cf":function(t,e,a){"use strict";a("7a82");var i=a("4ea4").default;Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var n=i(a("528a")),c=n.default.extend({data:function(){return{}},props:{title:{type:String},checked:{type:Boolean,default:!1},icon:{type:String,default:"/static/images/checkbox_unchecked.svg"},checkicon:{type:String,default:"/static/images/checkbox_checked.svg"}},methods:{},created:function(){}});e.default=c},"7b2c":function(t,e,a){"use strict";var i=a("2078"),n=a.n(i);n.a},a2c5:function(t,e,a){"use strict";a.d(e,"b",(function(){return i})),a.d(e,"c",(function(){return n})),a.d(e,"a",(function(){}));var i=function(){var t=this.$createElement,e=this._self._c||t;return e("v-uni-view",{staticClass:"navibar"},[e("v-uni-image",{attrs:{src:this.icon}}),e("v-uni-navigator",{staticStyle:{flex:"1","margin-left":"12px"},attrs:{url:this.url}},[e("v-uni-text",[this._v(this._s(this.title))])],1),e("v-uni-view",{staticClass:"header"},[this._t("default")],2),e("v-uni-navigator",{staticClass:"default",attrs:{url:this.url}},[e("v-uni-image",{attrs:{src:"/static/images/arrow.svg"}})],1)],1)},n=[]},a4f0:function(t,e,a){var i=a("b3bc");i.__esModule&&(i=i.default),"string"===typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);var n=a("4f06").default;n("4cdcbcfe",i,!0,{sourceMap:!1,shadowMode:!1})},aae0:function(t,e,a){"use strict";a.r(e);var i=a("a2c5"),n=a("d1b8");for(var c in n)["default"].indexOf(c)<0&&function(t){a.d(e,t,(function(){return n[t]}))}(c);a("7b2c");var s=a("f0c5"),r=Object(s["a"])(n["default"],i["b"],i["c"],!1,null,"34040b0c",null,!1,i["a"],void 0);e["default"]=r.exports},b3bc:function(t,e,a){var i=a("24fb");e=i(!1),e.push([t.i,"/* components/from/fixedcheck.wxss */.check[data-v-09a671d4]{width:16px;height:16px;margin-right:8px}uni-text.fixedcheck[data-v-09a671d4]{font-size:14px;color:#4b5667}",""]),t.exports=e},b622d:function(t,e,a){"use strict";a.d(e,"b",(function(){return n})),a.d(e,"c",(function(){return c})),a.d(e,"a",(function(){return i}));var i={navibar:a("aae0").default,fixedcheck:a("ff46").default},n=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("v-uni-view",{staticStyle:{display:"flex","flex-direction":"column",height:"100%",position:"fixed",width:"100%"}},[a("nav"),a("v-uni-view",{staticStyle:{display:"flex","flex-direction":"column"}},[a("v-uni-view",{staticStyle:{height:"10px","background-color":"#f0f0f0"}}),a("v-uni-view",{staticClass:"banner-view"},[a("v-uni-navigator",{attrs:{url:"../list/collect?type=N"}},[a("v-uni-view",[a("v-uni-text",[t._v(t._s(t.count.noticeCount))]),t._v("我关注的公告")],1)],1),a("v-uni-navigator",{attrs:{url:"../list/collect?type=D"}},[a("v-uni-view",[a("v-uni-text",[t._v(t._s(t.count.detailsCount))]),t._v("我关注的职位")],1)],1),a("v-uni-navigator",{attrs:{url:"../list/collect?type=A"}},[a("v-uni-view",[a("v-uni-text",[t._v(t._s(t.count.aiCount))]),t._v("我的AI推送")],1)],1)],1),a("v-uni-view",{staticStyle:{height:"10px","background-color":"#f0f0f0"}}),a("v-uni-view",{staticStyle:{padding:"0 20px","background-color":"#fff"}},[a("navibar",{attrs:{title:"我的报考条件",icon:"/static/images/icon_mine_plus.svg",url:"../mine/requirements"}}),a("navibar",{attrs:{title:"是否使用AI推荐",icon:"/static/images/icon_mine_ai.svg",url:"../mine/requirements"}},[a("fixedcheck",{attrs:{checkicon:"/static/images/icon_switch_open.svg",icon:"/static/images/icon_switch_close.svg",checked:t.isAi},nativeOn:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.aiTap.apply(void 0,arguments)}}})],1),a("navibar",{attrs:{title:"意见反馈",icon:"/static/images/icon_mine_write.svg",url:"../mine/feedback"}}),a("navibar",{attrs:{title:"关于我们",icon:"/static/images/icon_mine_about.svg",url:"../mine/about"}})],1),a("v-uni-view",{staticStyle:{padding:"16px","font-size":"14px",color:"#86909c"}},[a("v-uni-view",{staticStyle:{"font-size":"14px",color:"#4b5667",display:"flex","align-items":"center","margin-bottom":"15px"}},[a("v-uni-image",{staticClass:"icon",staticStyle:{"margin-right":"8px"},attrs:{src:"/static/images/icon_warring.svg"}}),t._v("免责说明")],1),t._v("关于搜索的准确度，大学专业称谓的准确度等等，提请用户一定以官网为准。我们提供的信息仅作为参考。")],1)],1)],1)},c=[]},bd84:function(t,e,a){"use strict";a.r(e);var i=a("b622d"),n=a("1d9d");for(var c in n)["default"].indexOf(c)<0&&function(t){a.d(e,t,(function(){return n[t]}))}(c);a("e813");var s=a("f0c5"),r=Object(s["a"])(n["default"],i["b"],i["c"],!1,null,"126b7f0d",null,!1,i["a"],void 0);e["default"]=r.exports},d1b8:function(t,e,a){"use strict";a.r(e);var i=a("110c"),n=a.n(i);for(var c in i)["default"].indexOf(c)<0&&function(t){a.d(e,t,(function(){return i[t]}))}(c);e["default"]=n.a},d414:function(t,e,a){var i=a("24fb");e=i(!1),e.push([t.i,"/* components/navi/navibar.wxss */.navibar[data-v-34040b0c]{display:flex;flex-direction:row;padding:16px 0;align-items:center;border-bottom:1px solid #f2f3f5}.navibar > uni-image[data-v-34040b0c]{width:16px;height:16px}uni-navigator > uni-image[data-v-34040b0c]{width:16px;height:16px}.default[data-v-34040b0c]{display:none}.header:empty + .default[data-v-34040b0c]{display:block}",""]),t.exports=e},e813:function(t,e,a){"use strict";var i=a("35c5"),n=a.n(i);n.a},ff46:function(t,e,a){"use strict";a.r(e);var i=a("338d"),n=a("0205");for(var c in n)["default"].indexOf(c)<0&&function(t){a.d(e,t,(function(){return n[t]}))}(c);a("2405");var s=a("f0c5"),r=Object(s["a"])(n["default"],i["b"],i["c"],!1,null,"09a671d4",null,!1,i["a"],void 0);e["default"]=r.exports}}]);