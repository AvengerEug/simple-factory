package com.eugene.Enum;

public enum PaymentTypeEnum {

    // 担保交易, 账期交易
    SECURED(0), ACCOUNT(1);

    PaymentTypeEnum(int value ) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return this.value;
    }

    public static PaymentTypeEnum valueOf(int value) {
        PaymentTypeEnum[] paymentTypeEnums = PaymentTypeEnum.values();
        for (PaymentTypeEnum paymentTypeEnum : paymentTypeEnums) {
            if (paymentTypeEnum.getValue() == value) {
                return paymentTypeEnum;
            }
        }

        return null;
    }
}
