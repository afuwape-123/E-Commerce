package com.gracie.ecommerce.security.security;

public enum TokenType {
    BEARER_TOKEN, REFRESH_TOKEN, PASSWORD_RESET_TOKEN, CREATE_PASSWORD_TOKEN;


    /**
     * Returns the name of this enum constant, as contained in the
     * declaration.  This method may be overridden, though it typically
     * isn't necessary or desirable.  An enum type should override this
     * method when a more "programmer-friendly" string form exists.
     *
     * @return the name of this enum constant
     */
    @Override
    public String toString() {
        switch (this){
            case BEARER_TOKEN:return "Bearer";
            case REFRESH_TOKEN:return "Refresh";
            case PASSWORD_RESET_TOKEN:return "Password Reset";
            case CREATE_PASSWORD_TOKEN:return "Create Password";
            default: return null;
        }

    }
}
