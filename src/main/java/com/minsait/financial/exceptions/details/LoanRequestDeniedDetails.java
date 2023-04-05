package com.minsait.financial.exceptions.details;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LoanRequestDeniedDetails {
    private String title;
    private int status;
    private LocalDateTime timestamp;
    private String message;

    private LoanRequestDeniedDetails(){

    }


    public static final class LoanRequestDeniedDetailsBuilder {
        private String title;
        private int status;
        private LocalDateTime timestamp;
        private String message;

        private LoanRequestDeniedDetailsBuilder() {
        }

        public static LoanRequestDeniedDetailsBuilder newBuilder() {
            return new LoanRequestDeniedDetailsBuilder();
        }

        public LoanRequestDeniedDetailsBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public LoanRequestDeniedDetailsBuilder withStatus(int status) {
            this.status = status;
            return this;
        }

        public LoanRequestDeniedDetailsBuilder withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public LoanRequestDeniedDetailsBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public LoanRequestDeniedDetails build() {
            LoanRequestDeniedDetails loanRequestDeniedDetails = new LoanRequestDeniedDetails();
            loanRequestDeniedDetails.title = this.title;
            loanRequestDeniedDetails.timestamp = this.timestamp;
            loanRequestDeniedDetails.status = this.status;
            loanRequestDeniedDetails.message = this.message;
            return loanRequestDeniedDetails;
        }
    }
}
