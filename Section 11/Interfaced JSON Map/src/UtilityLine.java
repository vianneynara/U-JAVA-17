enum UtilityType {
    ELECTRICAL, FIBER_OPTIC, GAS, WATER
}

public class UtilityLine implements Mappable {

    private String name;
    private UtilityType type;

    public UtilityLine(String name, UtilityType type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getLabel() {
        return name + " (" + type + ")";
    }

    @Override
    public String getMarker() {
        return switch (type) {
            case ELECTRICAL -> Color.RED + " " + LineMarkers.DASHED;
            case FIBER_OPTIC -> Color.ORANGE + " " + LineMarkers.DOTTED;
            case GAS -> Color.GREEN + " " + LineMarkers.DOTTED;
            case WATER -> Color.BLUE + " " + LineMarkers.DASHED;
            default -> Color.BLACK + " " + LineMarkers.SOLID;
        };
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }

    @Override
    public String toJSON() {
        return Mappable.super.toJSON() + """
            , "name:": "%s", "type": "%s" """
            .formatted(name, type);
    }
}
