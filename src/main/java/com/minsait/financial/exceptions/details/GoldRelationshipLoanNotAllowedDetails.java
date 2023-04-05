package com.minsait.financial.exceptions.details;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GoldRelationshipLoanNotAllowedDetails {
    private String title;
    private int status;
    private LocalDateTime timestamp;
    private String message;

    private GoldRelationshipLoanNotAllowedDetails(){

    }


    public static final class GoldRelationshipLoanNotAllowedDetailsBuilder {
        private String title;
        private int status;
        private LocalDateTime timestamp;
        private String message;

        private GoldRelationshipLoanNotAllowedDetailsBuilder() {
        }

        public static GoldRelationshipLoanNotAllowedDetailsBuilder newBuilder() {
            return new GoldRelationshipLoanNotAllowedDetailsBuilder();
        }

        public GoldRelationshipLoanNotAllowedDetailsBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public GoldRelationshipLoanNotAllowedDetailsBuilder withStatus(int status) {
            this.status = status;
            return this;
        }

        public GoldRelationshipLoanNotAllowedDetailsBuilder withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public GoldRelationshipLoanNotAllowedDetailsBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public GoldRelationshipLoanNotAllowedDetails build() {
            GoldRelationshipLoanNotAllowedDetails goldRelationshipLoanNotAllowedDetails = new GoldRelationshipLoanNotAllowedDetails();
            goldRelationshipLoanNotAllowedDetails.timestamp = this.timestamp;
            goldRelationshipLoanNotAllowedDetails.title = this.title;
            goldRelationshipLoanNotAllowedDetails.status = this.status;
            goldRelationshipLoanNotAllowedDetails.message = this.message;
            return goldRelationshipLoanNotAllowedDetails;
        }
    }
}
