package com.minsait.financial.exceptions.details;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CustomerDoesNotHaveALoanDetails {
    private String title;
    private int status;
    private LocalDateTime timestamp;
    private String message;


    private CustomerDoesNotHaveALoanDetails(){

    }

    public static final class CustomerDoesNotHaveALoanDetailsBuilder {
        private String title;
        private int status;
        private LocalDateTime timestamp;
        private String message;

        private CustomerDoesNotHaveALoanDetailsBuilder() {
        }

        public static CustomerDoesNotHaveALoanDetailsBuilder newBuilder() {
            return new CustomerDoesNotHaveALoanDetailsBuilder();
        }

        public CustomerDoesNotHaveALoanDetailsBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public CustomerDoesNotHaveALoanDetailsBuilder withStatus(int status) {
            this.status = status;
            return this;
        }

        public CustomerDoesNotHaveALoanDetailsBuilder withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public CustomerDoesNotHaveALoanDetailsBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public CustomerDoesNotHaveALoanDetails build() {
            CustomerDoesNotHaveALoanDetails customerDoesNotHaveALoanDetails = new CustomerDoesNotHaveALoanDetails();
            customerDoesNotHaveALoanDetails.title = this.title;
            customerDoesNotHaveALoanDetails.timestamp = this.timestamp;
            customerDoesNotHaveALoanDetails.message = this.message;
            customerDoesNotHaveALoanDetails.status = this.status;
            return customerDoesNotHaveALoanDetails;
        }
    }
}
