import java.time.LocalDate;
import java.util.Objects;


public record Wheather(LocalDate data, double minTemp, double maxTemp, Unit unit) {

    public Wheather {
        Objects.requireNonNull(data);
        Objects.requireNonNull(unit);
        if(maxTemp<minTemp){
            throw new IllegalArgumentException("Max temp cant be biggethan min temp");
        }

    }
    double minTempAS(Unit targetUnit){
        return Unit.convert(unit,targetUnit,minTemp);
    }

    double maxTempAS(Unit targetUnit){
        return Unit.convert(unit,targetUnit,maxTemp);
    }

    enum Unit{
        CELSIUS('C'),FAHRENHEIT('F');

        private final char unitSign;


        Unit(char unitSign) {
            this.unitSign = unitSign;
        }

        public char getUnitSign() {
            return unitSign;
        }

        static Unit fromUnitSign(String sign){
            return switch (sign){
                case "C"->Unit.CELSIUS;
                case "F"->Unit.FAHRENHEIT;
                default ->throw  new IllegalArgumentException("Nieobługiwana jednostka");
            };
        }

        static double convert(Unit from,Unit to,double value){
            if(from==CELSIUS&& to==FAHRENHEIT){
             return  value * 1.8 + 32;
            }else if(from==FAHRENHEIT && to==CELSIUS){
                return value-32/1.8;
            }else {
                return value;
            }

        }

    }

}



