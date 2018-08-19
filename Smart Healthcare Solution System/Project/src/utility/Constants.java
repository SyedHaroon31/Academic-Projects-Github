/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author Ashish
 */
public class Constants {
    
    public static enum ReqType{
        Fund("Fund"),InitTransfer("Inititate Transfer"),Other("Other");
        private String value;
        private ReqType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString() {
            return value;
        }
    }
    public static enum InitialFund{
        Mayor("40000000000");
        private String value;
        private InitialFund(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString() {
            return value;
        }
    }
    public static enum Status{
        Pending("Pending"),Processing("Processing"),Resolved("Resolved"),Forwarded("Forwarded"),Cancelled("Cancelled"),
        Processing_AM("Processing"),Resolved_AM("Resolved"),Forwarded_AM("Forwarded"),
        Processing_M("Processing"),Declined("Declined"),Forwarded_M("Forwarded"),
        Processing_T("Processing"),Completed("Completed"),;
        private String value;
        private Status(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString() {
            return (value);
        }
    }
        public static enum TrailLevel{
        Level1("Level1"),Level2("Level2"),Level3("Level3"),Level4("Level4");
        private String value;
        private TrailLevel(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
        @Override
        public String toString() {
            return (value);
        }
    }
}
