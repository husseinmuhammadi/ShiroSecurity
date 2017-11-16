package ir.team.insurance.complementary.web;

public enum Category {
    AGE_RANGE("ageRange"),
    DEPENDENT("dependent"),
    INSURED_INSURANCE_PLAN("insuredInsurancePlan"),
    PAYMENT_RECEIPT("paymentReceipt"),
    MEDICAL_CENTER("medicalCenter"),
    SIGN_UP("signUp"),
    INSURANCE_PLAN("insurancePlan"),
    PAYMENT("payment"),
    LIABILITY("liability"),
    INSURED("insured"),
    PLAN_TYPE("planType"),
    INSURANCE_LIABILITY("insuranceLiability"),
    RECEIPT_CATEGORY("ReceiptCategory"),
    INSURED_WORK_PLACE("InsuredWorkPlace"),
    RECEIPT("receipt"),
    ORIGINAL_INSURED("originalInsured"),
    INSURED_RECEIPT("insuredReceipt"),
    PAYMENT_RECEIPT_SUMMARY_REPORT("paymentReceiptSummaryReport"),
    RECEIPT_PAYABLE_AMOUNT_REPORT("receiptPayableAmountReport"),
    INSURED_REPORT("insuredReport");

    private String domainName;

    Category(String domainName) {
        this.domainName = domainName;
    }

    public String getDomainName() {
        return domainName;
    }
}
