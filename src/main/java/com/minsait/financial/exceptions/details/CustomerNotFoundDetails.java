package com.minsait.financial.exceptions.details;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CustomerNotFoundDetails {
    private String title;
    private int status;
    private LocalDateTime timestamp;
    private String message;

    private CustomerNotFoundDetails(){

    }

    public static final class CustomerNotFoundDetailsBuilder {
        private String title;
        private int status;
        private LocalDateTime timestamp;
        private String message;

        private CustomerNotFoundDetailsBuilder() {
        }

        public static CustomerNotFoundDetailsBuilder newBuilder() {
            return new CustomerNotFoundDetailsBuilder();
        }

        public CustomerNotFoundDetailsBuilder withTitulo(String title) {
            this.title = title;
            return this;
        }

        public CustomerNotFoundDetailsBuilder withStatus(int status) {
            this.status = status;
            return this;
        }

        public CustomerNotFoundDetailsBuilder withTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public CustomerNotFoundDetailsBuilder withMensagem(String message) {
            this.message = message;
            return this;
        }

        public CustomerNotFoundDetails build() {
            CustomerNotFoundDetails customerNotFoundDetails = new CustomerNotFoundDetails();
            customerNotFoundDetails.status = this.status;
            customerNotFoundDetails.timestamp = this.timestamp;
            customerNotFoundDetails.title = this.title;
            customerNotFoundDetails.message = this.message;
            return customerNotFoundDetails;
        }
    }
}
