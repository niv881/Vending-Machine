package utilities;

public enum Emoney {

    CENT(0.1),
    FIFTY_CENT(0.5),
    SHEKEL(1),
    TOW_SHEKEL(2),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    ONE_HUNDRED(100),
    TWO_HUNDRED(200),
    ;
    private final double value;

    Emoney(double value) {
        this.value = value;
    }

    public double getValue(){
        return value;
    }

}
