package com.ifs.ctpay.network;

/**
 * Created by Quangminhs on 7/3/2015.
 */
public class PGWService {
    /**
     * Danh sach cac service
     */
    public static final String CONTROLLER_OMS = "OmsController";

    public static final String CONTROLLER_SYSPARAMS = "SysParamsController";

    public static final String CONTROLLER_PARTNER = "PartnerController";

    public static final String CONTROLLER_USER_ACCOUNT = "UserAccountController";

    public static final String CONTROLLER_AUTHEN = "AuthenController";

    public static final String CONTROLLER_MENU = "MenuController";


    /**
     * Ten cac tham so truyen di trong broacast
     */
    public static final String PAYMENT_POS = "position";
    public static final String PAYMENT_AMOUNT = "amount";
    public static final String PAYMENT_BILLING_NO = "billingno";
    public static final String PAYMENT_TITLE_TYPE = "title_type";
    public static final String PAYMENT_PRODUC_CODE = "PRODUCT_CODE";

    public static final String KEY_DATA = "Data";
    public static final String KEY_TYPE = "Type";
    public static final String KEY_ERROR = "Error";
    public static final String KEY_POS = "Pos";
    public static final String KEY_ID = "Id";
    public static final String KEY_NAME = "Name";
    public static final String KEY_DRAWABLE = "Drawable";
    public static final String KEY_FEE = "Fee";
    public static final String KEY_TITLE = "Title";

    public static final String STATUS_ACT = "ACT";

    /*Cac loai Data*/
    public static final String TYPE_PAYMENT_BANK = "Bank";

    /* action parameter*/
    public static final String ACTION_PROCESS_WITHDRAW = "ProcessWithdraw";
    public static final String ACTION_FEETAXCALLREQUET = "FeeTaxCalRequest";
    public static final String ACTION_CONFIRM_WITHDRAW = "ConfirmWithdraw"; //Xac nhan rut tien
    public static final String ACTION_LIST_WITHDRAWAL_ACCOUNTS = "ListWithdrawableAccounts";
    public static final String ACTION_PROCESS_TRANSFER_INTERNAL = "ProcessTransferInternal";   //Chuyent tien giua cac ngan vi
    public static final String ACTION_LIST_TRANSFER_ABLE_ACCOUNTS = "ListTransferableAccounts";
    public static final String ACTION_LIST_TRANSFER_ABLE_TO = "ListTransferableTo";
    public static final String ACTION_GET_FULL_NAME_OF_CLIENT_BY_USERNAME = "GetFullNameOfClientByUserName";
    public static final String ACTION_PROCESS_TRANSFER_EXTERNAL = "ProcessTransferExternal";   //Chuyen tien tu vi sang vi

    public static final String ACTION_CONFIRM_TRANSFER_MONEY_INTERNAL = "ConfirmTransferMoneyInternal"; //xac nhan chuyen tien noi bo
    public static final String ACTION_CONFIRM_TRANSFER_MONEY_EXTERNAL = "ConfirmTransferMoneyExternal";
    public static final String ACCTION_LIST_CHANNEL = "ListChannel";
    public static final String ACCTION_LIST_CHANNEL_BY_CLIENT = "ListChannelByClient";
    public static final String ACTION_ACTIVATE_CLIENT_CHANNEL = "ActivateClientChannel";
    public static final String ACTION_DEACTIVATE_CLIENT_CHANNEL = "DeactivateClientChannel";

    public static final String ACTION_CHANGE_PASSWORD = "ChangePassword";
    public static final String ACTION_CHANGE_EMAIL = "ChangeEmail";
    public static final String ACTION_LIST_ACCESS_LOG_HISTORY = "ListAccessLogHistory";
    public static final String ACTION_CONFIRM_PAYMENT = "ConfirmPayment";
    public static final String ACTION_CONFIRM_PAYMENT_BANK = "ConfirmPaymentBank";
    public static final String ACTION_FEE_TAX_CALL_REQUET = "FeeTaxCalRequest";
    public static final String ACTION_PROCESS_EWALLET_PAYMENT = "ProcessEwalletPayment";        //Tao giao dich thanh toan hoa don bang vi dien tu
    public static final String ACTION_PROCESS_BANK_PAYMENT = "ProcessBankPayment";              //Tao giao dich thanh toan hd bang the hoac tk ngan hang
    public static final String ACTION_PROCESS_CREDIT_CARD_PAYMENT = "ProcessCreditCardPayment";  //Tao giao dich thanh toan hd bang the tin dung
    public static final String ACTION_GET_ACCOUNT_BALANCE = "GetAccountBalance"; //Lay so du tai khoan kha dung
    public static final String ACTION_CONFIRM_DEPOSIT_BANK = "ConfirmDepositBank"; // Xac nhan nap tien tu ngan han
    public static final String ACTION_PROCESS_DEPOSIT_MOBILE_CARD = "ProcessDepositMobileCard";//Nap tien bang the cao
    public static final String ACTION_DEPOSITABLES_ACCOUNT = "ListDepositableAccounts";//ds cac tai khoan vi co the nap
    public static final String ACTION_FORGOT_PIN = "ForgotPin";
    public static final String ACTION_LIST_TRANSACTION_BY_CLIENT_ID = "ListTransactionByClientId";

    public static final String ACCTION_LIST_REGISTED_PRODUCT_GROUP = "ListRegistedProductGroup";
    public static final String ACCTION_LIST_INTER_ACCOUNT = "ListInterAccount";
    public static final String ACTION_UNREGISTER_PRODUCT_GROUP = "UnRegisterProductGroup";
    public static final String ACTION_REGISTER_PRODUCT_GROUP = "RegisterProductGroup";
    public static final String ACTION_LIST_REGISTED_PRODUCT_GROUP = "ListRegistedProductGroup";
    public static final String ACTION_LIST_PRODUCT_GROUP_REG_REQUIRED = "ListProductGroupRegRequired";

    public static final String ACTION_REGISTER = "Register";
    public static final String ACTION_UPDATE = "UpdateOwnerInfo";
    public static final String ACTION_LIST_DISTRICT = "ListDistrict";

    public static final String ACTION_ADD_CLIENT_LOGIN = "AddClientLogin";
    public static final String ACTION_LIST_CLIENT = "ListClientLoginByType";
    public static final String ACTION_REMOVE_CLIENT = "RemoveClientLogin";
    public static final String ACTION_SET_LOGIN_ABLE = "SetLoginable";
    public static final String ACTION_CHANGE_CONTACT_NUMBER = "ChangeContactNumber";

    public static final String ACTION_LIST_INTER_ACCOUNT = "ListInterAccount";
    public static final String ACTION_CREATE_INTER_ACCOUNT = "CreateInterAccount";
    public static final String ACTION_DELETE_INTER_ACCOUNT = "DeleteInterAccount";
    public static final String ACTION_LIST_TRANSACTION = "ListClientTransaction";

    public static final String ACTION_FORGET_PASSWORD = "ForgotPassword";
    public static final String ACTION_REMOVE_CREDIT_CRARD = "RemoveCreditCard";
    public static final String ACTION_VERIFY_BANK_ACCOUNT = "VerifyBankAccount";
    public static final String ACTION_ADD_ATM_ACCOUNT = "AddATMAccount";
    public static final String ACTION_REMOVE_ATM_ACCOUNT = "RemoveATMAccount";
    public static final String ACTION_VERIFY_ATM_ACCOUNT = "VerifyATMAccount";

    public static final String ACTION_LIST_CLIENT_ACCOUNT = "ListClientAccount";
    public static final String ACTION_LIST_ACTIVE_CLIENT_ACCOUNT = "ListActiveClientAccount";
    public static final String ACTION_LIST_ADD_BANK_ACCOUNT = "AddBankAccount";
    public static final String ACTION_LIST_USER_CREDIT_CARD = "ListUserCreditCard";
    public static final String ACTION_LIST_USER_BANK_ACCOUNT = "ListUserBankAccount";
    public static final String ACTION_LIST_USER_ATM_ACCOUNT = "ListUserATMAccount";
    public static final String ACTION_REMOVE_BANK_ACCOUNT = "RemoveBankAccount";
    public static final String ACTION_ADD_CREDIT_CARD_ACCOUNT = "AddCreditCardAccount";
    public static final String ACTION_VERIFY_CREDIT_CARD_ACCOUNT = "VerifyCreditCardAccount";
    public static final String ACTION_VERIFY_ACCOUNT = "VerifyAccount";

    public static final String ACTION_LIST_AUDIT_LOG = "ListAuditLog";
    public static final String ACTION_LIST_BANK = "ListBank";
    public static final String ACTION_LIST_PARTNER_BY_PROCESSING_CODE = "ListPartnerByProcessingCode";
    public static final String ACTION_GET_PRODUCT_CODE_BY_PROCESSING_CODE = "GetProductCodeByProcessingCode";
    public static final String ACTION_LIST_CREDIT_CARD = "ListUserCreditCard";
    public static final String ACTION_GET_SERVICES = "GetServices";
    public static final String ACTION_LIST_PARTNER_PRODUCT_INF_EX = "ListPartnerProductInfEx";
    public static final String ACTION_PROCESS_DEPOSIT_BANK = "ProcessDepositBankAccount";//Nap tien bang tk ngan hang
    public static final String ACTION_FILTER_BRANCH = "FilterBranch"; // ds chi nhanh ngan hang theo bank va tinh
    public static final String ACTION_LIST_PROVINCE = "ListProvince"; // danh sach tinh thanh pho
    public static final String ACTION_PROCESS_DEPOSIT_CREDIT_CARD = "ProcessDepositCreditCard";//Nap tien bang the tin dung
    public static final String ACTION_DEPOSIT_ABLE_ACCOUNTS = "ListDepositableAccounts";//ds cac tai khoan vi co the nap
    public static final String ACTION_PROCESS_DEPOSIT_ATM = "ProcessDepositATM"; //Nap tien bang the ghi no noi dia
    public static final String ACTION_FEE_TAX_CALL_REQUEST = "FeeTaxCalRequest";
    public static final String ACTION_LIST_USER_ATM_ACCOUNTS = "ListUserATMAccount";
    public static final String ACTION_LIST_USER_BANK_ACCOUNTS = "ListUserBankAccount";
    public static final String ACTION_GET_USER = "GetClientUser";
    public static final String ACTION_AUTHENTICATE = "authenticate";
    public static final String ACTION_LIST_TRANSACTION_DETAIL_BY_TRAN_REF = "ListTransactionDetailByTranRef";
    public static final String ACTION_LIST_ACCOUNT_STATEMENT = "ListAccountStatement";
    public static final String ACTION_LIST_SUBMENU_BY_MENU = "ListSubMenuByMenu";
    public static final String ACTION_LIST_MENU = "ListMenu";
    public static final String ACTION_LIST_PARTNER_BY_SUB_MENU = "ListPartnerBySubMenu";
    public static final String ACTION_GET_PARTNER_PRODUCT_INPUT_FIELD = "GetPartnerProductInputField";
    public static final String ACTION_REQUEST_PARTNER_PAYMENT_INF = "RequestPartnerPaymentInf";
    public static final String ACTION_PLACE_MERCHANT_ORDER = "PlaceMerchantOrder";
    public static final String ACTION_GET_MERCHANT_ORDER = "GetMerchantOrder";


    /*Param service*/
    public static final String PARAM_INSTRUCTION = "instruction";
    public static final String PARAM_MENU_CODE = "menuCode";
    public static final String PARAM_SUB_MENU_CODE = "subMenuCode";
    public static final String PARAM_PRODUCT_CODE = "productCode";
    public static final String PARAM_USER_NAME = "username";
    public static final String PARAM_BANK_ACC_ID = "bankAccId";
    public static final String ACTION_LIST_TRANSFER_MAP = "ListTransferMap";
    public static final String PARAM_PERSONAL = "personal";
    public static final String PARAM_FROM_ACCOUNT_TYPE = "fromAccountType";
    public static final String PARAM_TRANSFER_TOCLIENT = "toClient";
    public static final String PARAM_TRANSFER_FROMACCOUNTTYPE = "fromAccountType";


    public static final String PARAM_CHANNEL_CODE = "channelCode";
    public static final String PARAM_OLD_PASSWORD = "oldPassword";
    public static final String PARAM_NEW_PASSWORD = "newPassword";

    public static final String PARAM_NEW_EMAIL = "newEmail";
    public static final String PARAM_LIMIT = "limit";
    public static final String PARAM_LAST_TRY = "lastTry";
    public static final String PARAM_PIN_CODE = "pinCode";
    public static final String PARAM_SYSTEM_OTP = "systemOtp";

    public static final String PARAM_BANK_PAYMENT_BANK_ACCID = "bankAccId";     //Tham so tthd bang ngan hang
    public static final String PARAM_CREDIT_AC_ID = "creditAccId";     //Tham so tthd bang the tin dung                   //So tien nhan hoac chuyen
    public static final String PARAM_SERVICE_CODE = "serviceCode";              //Code dich vu
    public static final String PARAM_BILLING_NO = "billingNo";                 //So hoa don hay tai khoan
    public static final String PARAM_ACCOUNT_TYPE = "accountType"; //Loai tai khaon vd: EWA

    public static final String PARAM_TRAN_REF = "tranRef";
    public static final String PARAM_BANK_OTP = "bankOtp";

    public static final String PARAM_MOBICARD_SERVICECODE = "serviceCode";
    public static final String PARAM_MOBICARD_CARDSERIAL = "cardSerial";
    public static final String PARAM_MOBICARD_CARDCODE = "cardCode";
    public static final String PARAM_TOACCOUNTTYPE = "toAccountType"; //Ngan vi dc nhan

    public static final String PARAM_TRANSTIME = "transTime";
    public static final String PARAM_TRANREF = "tranRef";
    public static final String PARAM_PAGE_INDEX = "pageIndex";

    public static final String PARAM_CLIENT_ID = "clientId";
    public static final String PRAM_PRODUCT_GROUP = "productGroup";

    public static final String PARAM_FULL_NAME = "fullName";

    public static final String PARAM_USER_ID = "userId";
    public static final String PARAM_LOGIN_ABLE = "loginable";
    public static final String PARAM_MOBILE = "mobile";
    public static final String PARAM_USERNAME = "userName";
    public static final String PARAM_CONTACT_NO = "contactNo";

    public static final String PARAM_PRI_ACC_CODE = "priAccCode";
    public static final String PARAM_INTER_ACC_CODE = "interAccCode";
    public static final String PARAM_EMAIL = "email";
    public static final String PARAM_ACCOUNT_NUMBER = "accountNumber";
    public static final String PARAM_VERIFY_AMOUNT = "verifyAmount";

    public static final String PARAM_BANK_BANK_CODE = "bankCode";
    public static final String PARAM_ACCOUNT_NO = "accountNo";
    public static final String PARAM_BANK_ACCOUNT_NUMBER = "bankAccountNumber";
    public static final String PARAM_OTP_TOKEN = "otpToken";

    public static final String PARAM_CREDIT_ACC_IT = "creditAccId";
    public static final String PARAM_TO_ACCOUNT_TYPE = "toAccountType"; //Ngan vi dc nhan
    public static final String PARAM_AMOUNT = "amount";               //So tien nhan hoac chuyen
    public static final String PARAM_BANK_OWNER_NAME = "ownerName";
    public static final String PARAM_CARD_NUMBER = "cardNumber";
    public static final String PARAM_BANK_CODE = "bankCode";
    public static final String PARAM_OPEN_DATE = "openDate";
    public static final String PARAM_OWNER_NAME = "ownerName";
    public static final String PARAM_BANK_BRANCH_CODE = "branchCode"; //Chi dung cho nap tien vao vi tu ngan hang
    public static final String PARAM_PROVINCE_CODE = "provinceCode";
    public static final String PARAM_BANK_BRANCH_NAME = "branchName";
    public static final String PARAM_PROCESSING_CODE = "processingCode";
    public static final String PARAM_PARTNER_CODE = "partnerCode";
    public static final String PARAM_PARTNER_SERVICE_CODE = "partnerServiceCode";
    public static final String PARAM_NARRATIVE = "narrative";
    public static final String IS_CHARGE_SENDER = "is_charge_sender";

    public static final String PARAM_ACCOUNT_ID = "accountId";
    public static final String PARAM_FROM_DATE = "fromDate";
    public static final String PARAM_TO_DATE = "toDate";
    public static final String PARAM_PAGE_SIZE = "pageSize";
    public static final String PARAM_CURRENT_PAGE = "curentPage";
    public static final String PARAM_PROVICE_CODE = "provinceCode";
    public static final String ACTION_LIST_DICTRICT = "ListDistrict";
    public static final String PARAM_OLD_PIN = "oldPin";
    public static final String PARAM_NEW_PIN = "newPin";
    public static final String PARAM_PASSWORD = "password";
    public static final String ACTION_CHANGE_PIN = "ChangePin";

}
