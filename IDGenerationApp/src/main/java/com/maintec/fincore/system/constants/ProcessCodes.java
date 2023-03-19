package com.maintec.fincore.system.constants;

public enum ProcessCodes {
   SB_ACCOUNT_DETAILS("SB_ACCOUNT_DETAILS"),
   STOCK_DATA_ENTRY("STOCK_DATA_ENTRY"),
   TXN_DELETION("TXN_DELETION"),
   SB_ACCOUNT_OPEN_WITH_CASH("SB_ACCOUNT_OPEN_WITH_CASH"),
   SB_ACCOUNT_OPEN_WITHOUT_CASH("SB_ACCOUNT_OPEN_WITHOUT_CASH"),
   SB_CASH_RECEIPT("SB_CASH_RECEIPT"),
   SB_CASH_WDL("SB_CASH_WDL"),
   SB_TRANSFER_VOUCHER("SB_TRANSFER_VOUCHER"),
   SB_ACCOUNT_CLOSING_BY_PODD("SB_ACCOUNT_CLOSING_BY_PODD"),
   SB_ACCOUNT_CLOSING_BY_CASH("SB_ACCOUNT_CLOSING_BY_CASH"),
   SB_ACCOUNT_CLOSING_BY_TRANSFER("SB_ACCOUNT_CLOSING_BY_TRANSFER"),
   SB_BOB_CASH_RECEIPT("SB_BOB_CASH_RECEIPT"),
   SB_BOB_CASH_PAYMENT("SB_BOB_CASH_PAYMENT"),
   CASH_RECEIPT_BY_CASH("CASH_RECEIPT_BY_CASH"),
   CASH_PAYMENT_BY_CASH("CASH_PAYMENT_BY_CASH"),
   CASH_RECEIPT_BY_TRANSFER("CASH_RECEIPT_BY_TRANSFER"),
   CASH_PAYMENT_BY_TRANSFER("CASH_PAYMENT_BY_TRANSFER"),
   ID_CREATION("ID_CREATION"),
   ID_CAUTION("ID_CAUTION"),
   ACCOUNT_MARKING("ACCOUNT_MARKING"),
   CHEQUE_BOOK_ISSUE("CHEQUE_BOOK_ISSUE"),
   STOP_PAYMENT("STOP_PAYMENT"),
   PODD_ISSUE_BY_CASH("PODD_ISSUE_BY_CASH"),
   PODD_ISSUE_BY_TRANSFER("PODD_ISSUE_BY_TRANSFER"),
   PODD_DUPLICATION("PODD_DUPLICATION"),
   PODD_REVALIDATION("PODD_REVALIDATION"),
   PODD_CANCELLATION("PODD_CANCELLATION"),
   PODD_STOP_REVOKE_PAYMENT("PODD_STOP_REVOKE_PAYMENT"),
   CHARGE_POSTING("CHARGE_POSTING"),
   GL_BATCH_CREATION("GL_BATCH_CREATION"),
   LOAN_ACCOUNT_OPEN("LOAN_ACCOUNT_OPEN"),
   LOAN_SANCTION("LOAN_SANCTION"),
   LOAN_DISBURSEMENT_BY_CASH("LOAN_DISBURSEMENT_BY_CASH"),
   LOAN_DISBURSEMENT_PODD("LOAN_DISBURSEMENT_PODD"),
   LOAN_DISBURSEMENT_TO_SBCA("LOAN_DISBURSEMENT_TO_SBCA"),
   LOAN_RECOVERY_BY_CASH("LOAN_RECOVERY_BY_CASH"),
   QUICK_LOAN_DISBURSEMENT_TO_SBCA("QUICK_LOAN_DISBURSEMENT_TO_SBCA"),
   LOAN_RECOVERY_BY_TRANSFER("LOAN_RECOVERY_BY_TRANSFER"),
   SUSPENSE_TRANSFER_VOUCHER("SUSPENSE_TRANSFER_VOUCHER"),
   DEPOSIT_ACCOUNT_OPEN("DEPOSIT_ACCOUNT_OPEN"),
   DEPOSIT_CASH_RECEIPT("DEPOSIT_CASH_RECEIPT"),
   DEPOSIT_BULK_INTEREST_PAYEMENT("DEPOSIT_BULK_INTEREST_PAYEMENT"),
   DEPOSIT_INTEREST_CALCULATION("DEPOSIT_INTEREST_CALCULATION"),
   DEPOSIT_INTEREST_TRANSFER("DEPOSIT_INTEREST_TRANSFER"),
   DEPOSIT_INTEREST_CASH_PAYMENT("DEPOSIT_INTEREST_CASH_PAYMENT"),
   DEPOSIT_ACCOUNT_CLOSE("DEPOSIT_ACCOUNT_CLOSE"),
   DEPOSIT_ACCOUNT_RENEWAL("DEPOSIT_ACCOUNT_RENEWAL"),
   DEPOSIT_AUTO_CLOSURE("DEPOSIT_AUTO_CLOSURE"),
   SHARE_ACCOUNT_OPEN("SHARE_ACCOUNT_OPEN"),
   SHARE_ACCOUNT_OPEN_WITH_CASH("SHARE_ACCOUNT_OPEN_WITH_CASH"),
   DRF_ACCOUNT_OPEN("DRF_ACCOUNT_OPEN"),
   MBF_ACCOUNT_OPEN("MBF_ACCOUNT_OPEN"),
   SHARE_ACCOUNT_OPEN_BY_TRANSFER("SHARE_ACCOUNT_OPEN_BY_TRANSFER"),
   ADDITIONAL_SHARES_THROUGH_CASH("ADDITIONAL_SHARES_THROUGH_CASH"),
   SHARE_DIVIDEND_PAYMENT_THROUGH_TANSFER("SHARE_DIVIDEND_PAYMENT_THROUGH_TANSFER"),
   SHARE_DIVIDEND_PAYMENT_THROUGH_CASH("SHARE_DIVIDEND_PAYMENT_THROUGH_CASH"),
   SHARE_REFUND("SHARE_REFUND"),
   SHARE_CASH_PAYMENT("SHARE_CASH_PAYMENT"),
   ADDITIONAL_SHARES_THROUGH_SBCA("ADDITIONAL_SHARES_THROUGH_SBCA"),
   ADDITIONAL_SHARES_THROUGH_SUSPENSE("ADDITIONAL_SHARES_THROUGH_SUSPENSE"),
   SHARE_REFUND_WITH_CASH("SHARE_REFUND_WITH_CASH"),
   SHARE_REFUND_WITH_TRANSFER("SHARE_REFUND_WITH_TANSFER"),
   CLEARING_SUSPENSE("CLEARING_SUSPENSE"),
   CLEARING_DIRECT("DIRECT_CLEARING"),
   CHEQUE_DISCOUNT("CHEQUE_DISCOUNT"),
   CLEARING_ACCOUNTING("CLEARING_ACCOUNTING"),
   LOAN_DISBURSEMENT_ADDITONAL("LOAN_DISBURSEMENT_ADDITONAL"),
   TRANSFER_RETURN_CHARGE("TRANSFER_RETURN_CHARGE"),
   PAID_THROUGH_CLEARING("PAID_THROUGH_CLEARING"),
   RCB_BULK_RECOVERY("RCB_BULK_RECOVERY"),
   DRF_RECOVERY("DRF_RECOVERY"),
   MBF_RECOVERY("MBF_RECOVERY"),
   LOAN_RECOVERY("LOAN_RECOVERY"),
   RD_RECOVERY("RD_RECOVERY"),
   SHARE_RECOVERY("SHARE_RECOVERY"),
   SB_RECOVERY("SB_RECOVERY"),
   TRANSFER_VOUCHER_GENERAL("TRANSFER_VOUCHER_GENERAL"),
   PIGMY_WITHDRAWAL_CLOSURE("PIGMY_WITHDRAWAL_CLOSURE"),
   SI_EXECUTION_TRANSFER("SI_EXECUTION_TRANSFER"),
   Ported_from_bank_vision("Ported from bank vision"),
   PIGMY_ACCOUNT_OPEN_WITH_CASH("PIGMY_ACCOUNT_OPEN_WITH_CASH"),
   PIGMY_ACCOUNT_OPEN_WITH_ZERO_BALANCE("PIGMY_ACCOUNT_OPEN_WITH_ZERO_BALANCE"),
   PIGMY_COLLECTION_BULK_ACCOUNTING("PIGMY_COLLECTION_BULK_ACCOUNTING"),
   SINGLE_TO_MULTIPLE("SINGLE_TO_MULTIPLE_TXN"),
   ODCC_NEGATIVE_INTEREST_POSTING("ODCC_NEGATIVE_INTEREST_TXN"),
   OVER_DUE_RECOVERY("OVER_DUE_RECOVERY_TXN"),
   PORTING_BALANCE_INITIALIZATION("PORTING_BALANCE_INITIALIZATION"),
   CHIT_CASH_RECEIPT("CHIT_CASH_RECEIPT"),
   CHIT_LOAN_ACCOUNT_OPEN("CHIT_LOAN_ACCOUNT_OPEN"),
   CHIT_TRANSFER_RECEIPT("CHIT_TRANSFER_RECEIPT"),
   CBB_LOAN_DISBURSEMENT_TRANSFER("CBB_LOAN_DISBURSEMENT_TRANSFER"),
   STOCK_TAKING_AND_ISSUE("STOCK_TAKING_AND_ISSUE"),
   AUTO_ACCOUNT_RENEWAL("AUTO_ACCOUNT_RENEWAL"),
   SI_EXECUTION_CHARGE("SI_EXECUTION_CHARGE"),
   SI_ENTRY("SI_ENTRY"),
   ABB_TRANSFER_VOUCHER_GENERAL("ABB_TRANSFER_VOUCHER_GENERAL"),
   ABB_CASH_RECEIPT("ABB_CASH_RECEIPT"),
   ABB_CASH_WITHDRAWAL("ABB_CASH_WITHDRAWAL"),
   PODDAPC_VOUCHER_BY_CASH("PODDAPC_VOUCHER_BY_CASH"),
   DEPOSIT_POSTING_WITH_SIENTRY("DEPOSIT_POSTING_WITH_SIENTRY"),
   SHARE_ACCOUNT_OPEN_BY_EXIST_ACCOUNT("CONVERT_ACCOUNT"),
   MIGRATION_BALNCE("MIGRATION_BALNCE"),
   PIGMY_COLLECTION_AGENT("PIGMY_COLLECTION_AGENT");

   private String cashTXNCode;

   private ProcessCodes(String cashTXNCode) {
      this.cashTXNCode = cashTXNCode;
   }

   public String getCashTXNCode() {
      return this.cashTXNCode;
   }
}
