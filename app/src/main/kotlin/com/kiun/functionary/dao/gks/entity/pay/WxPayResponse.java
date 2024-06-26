package com.kiun.functionary.dao.gks.entity.pay;


/**
 *
 */
public class WxPayResponse {

    /**
     * 应用ID string[1,32]	是	直连商户申请的公众号或移动应用appid
     * 示例值：wxd678efh567hg6787
     */
    private  String appid;

    /**
     * 商户号	mchid	string[1,32]	是	商户的商户号，由微信支付生成并下发。
     * 示例值：1230000109
     */
    private String mchid;

    /**
     * 商户订单号	out_trade_no	string[6,32]	是	商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一。
     * 特殊规则：最小字符长度为6
     * 示例值：1217752501201407033233368018
     */
    private String out_trade_no;

    /**
     * 微信支付订单号	transaction_id	string[1,32]	是	微信支付系统生成的订单号。
     * 示例值：1217752501201407033233368018
     */
    private String transaction_id;

    /**
     * 交易类型	trade_type	string[1,16]	是	交易类型，枚举值：
     * JSAPI：公众号支付
     * NATIVE：扫码支付
     * APP：APP支付
     * MICROPAY：付款码支付
     * MWEB：H5支付
     * FACEPAY：刷脸支付
     * 示例值：MICROPAY
     */
    private String trade_type;

    /**
     * 交易状态	trade_state	string[1,32]	是	交易状态，枚举值：
     * SUCCESS：支付成功
     * REFUND：转入退款
     * NOTPAY：未支付
     * CLOSED：已关闭
     * REVOKED：已撤销（付款码支付）
     * USERPAYING：用户支付中（付款码支付）
     * PAYERROR：支付失败(其他原因，如银行返回失败)
     * 示例值：SUCCESS
     */
    private String trade_state;

    /**
     * 交易状态描述	trade_state_desc	string[1,256]	是	交易状态描述
     * 示例值：支付成功
     */
    private String trade_state_desc;

    /**
     * 付款银行	bank_type	string[1,32]	是	银行类型，采用字符串类型的银行标识。银行标识请参考《银行类型对照表》
     * 示例值：CICBC_DEBIT
     */
    private String bank_type;

    /**
     * 附加数据	attach	string[1,128]	否	附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用，实际情况下只有支付完成状态才会返回该字段。
     * 示例值：自定义数据
     */
    private String attach;

    /**
     * 支付完成时间	success_time	string[1,64]	是	支付完成时间，遵循rfc3339标准格式，格式为yyyy-MM-DDTHH:mm:ss+TIMEZONE，yyyy-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。
     * 示例值：2018-06-08T10:34:56+08:00
     */
    private String success_time;

    private WxPayer payer;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public String getTrade_state() {
        return trade_state;
    }

    public void setTrade_state(String trade_state) {
        this.trade_state = trade_state;
    }

    public String getTrade_state_desc() {
        return trade_state_desc;
    }

    public void setTrade_state_desc(String trade_state_desc) {
        this.trade_state_desc = trade_state_desc;
    }

    public String getBank_type() {
        return bank_type;
    }

    public void setBank_type(String bank_type) {
        this.bank_type = bank_type;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getSuccess_time() {
        return success_time;
    }

    public void setSuccess_time(String success_time) {
        this.success_time = success_time;
    }

    public WxPayer getPayer() {
        return payer;
    }

    public void setPayer(WxPayer payer) {
        this.payer = payer;
    }
}
