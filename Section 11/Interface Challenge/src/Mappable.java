enum Geometry {
    LINE, POINT, POLYGON
}

enum Color {
    RED, GREEN, BLUE, ORANGE, BLACK
}

enum LineMarkers {
    DASHED, DOTTED, SOLID
}

enum PointMarkers {
    CIRCLE, DIAMOND, RECTANGLE, TRIANGLE, PUSH_PIN, STAR
}

public interface Mappable {

    String JSON_PROPERTY = """
        "properties":{%s} """;

    static void toMap(Mappable mappable) {
        System.out.println(JSON_PROPERTY.formatted(mappable.toJSON()));
    }

    default String toJSON() {
        return """
          "type:": "%s", "label": "%s", "marker": "%s" """
          .formatted(getShape(), getLabel(), getMarker());
    }

    String getLabel();
    String getMarker();
    Geometry getShape();
}
