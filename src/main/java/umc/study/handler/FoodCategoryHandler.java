package umc.study.handler;

import umc.study.apiPayload.code.BaseErrorCode;

public class FoodCategoryHandler extends RuntimeException {
    private final BaseErrorCode errorCode;

    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode.toString());
        this.errorCode = errorCode;
    }

    public BaseErrorCode getErrorCode() {
        return errorCode;
    }
} 