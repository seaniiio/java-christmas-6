package christmas.domain;

public enum Badge {
    NONE("없음", 0),
    STAR("별", 5_000),
    TREE("트리", 10_000),
    SANTA("산타", 20_000);

    private final String name;
    private final int price;

    Badge(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public static Badge getBadge(int totalDiscountAmount) {
        Badge allocatedBadge = NONE;
        for (Badge badge : Badge.values()) {
            if (totalDiscountAmount >= badge.price) {
                allocatedBadge = badge;
            }
        }
        return allocatedBadge;
    }

    public String getName() {
        return this.name;
    }
}
