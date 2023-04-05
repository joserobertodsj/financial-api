package com.minsait.financial.exceptions.details;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class LoanNotFoundDetails {
    private String title;
    private int status;
    private LocalDateTime timestamp;
    private String message;

    private LoanNotFoundDetails(){

    }


    public static final class LoanNotFoundDetailsBuilder {
        private String title;
        private int status;
        private LocalDateTime timestamp;
        private String message;

        private LoanNotFoundDetailsBuilder() {
        }

        public static LoanNotFoundDetailsBuilder newBuilder() {
            return new LoanNotFoundDetailsBuilder();
        }

        public LoanNotFoundDetailsBuilder withTitulo(String title) {
            this.title = title;
            return this;
        }

        public LoanNotFoundDetailsBuilder withStatus(int status) {
            this.status = status;
            return this;
        }

        public LoanNotFoundDetailsBuilder withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public LoanNotFoundDetailsBuilder withMensagem(String message) {
            this.message = message;
            return this;
        }

        public LoanNotFoundDetails build() {
            LoanNotFoundDetails loanNotFoundDetails = new LoanNotFoundDetails();
            loanNotFoundDetails.status = this.status;
            loanNotFoundDetails.timestamp = this.timestamp;
            loanNotFoundDetails.message = this.message;
            loanNotFoundDetails.title = this.title;
            return loanNotFoundDetails;
        }
    }
}
