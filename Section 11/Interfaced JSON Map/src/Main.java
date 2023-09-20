import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Mappable> mappables = new ArrayList<>();

        mappables.add(new Building("Gedung DPR", UsageType.GOVERNMENT));
        mappables.add(new Building("Stadion Gelora Bung Karno", UsageType.ENTERTAINMENT));
        mappables.add(new Building("Pacific Place", UsageType.BUSINESS));

        mappables.add(new UtilityLine("RJ-45", UtilityType.FIBER_OPTIC));
        mappables.add(new UtilityLine("Sungai Ciliwung", UtilityType.WATER));

        for (var m : mappables) {
            Mappable.toMap(m);
        }
    }
}
