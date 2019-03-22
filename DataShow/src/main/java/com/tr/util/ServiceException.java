package com.tr.util;

import com.tr.domain.ShowErrorEnum;

public class ServiceException extends RuntimeException {
    private int errCode;
    private String message;

    public ServiceException(int errCode, String message) {
        super(message);
        this.errCode = errCode;
        this.message = message;
    }

    public ServiceException(ShowErrorEnum err) {
        super(err.getErrorMessage());
        this.errCode = err.getErrorCode();
        this.message = err.getErrorMessage();
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getMessage() {
        return this.message;
    }

    public void setErrCode(final int errCode) {
        this.errCode = errCode;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ServiceException)) {
            return false;
        } else {
            ServiceException other = (ServiceException)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getErrCode() != other.getErrCode()) {
                return false;
            } else {
                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ServiceException;
    }


    public String toString() {
        return "ServiceException(errCode=" + this.getErrCode() + ", message=" + this.getMessage() + ")";
    }
}