package challenges;

public class PaintJob {
    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        if ((width <= 0) || (height <= 0) || (areaPerBucket <= 0) || (extraBuckets < 0)) {
            return -1;
        }
//        double area = width * height;
//        System.out.println(area);
//        int bucketNeeded = (int) Math.ceil(area / areaPerBucket) - extraBuckets;
//        System.out.println(bucketNeeded);
//        return bucketNeeded;

        int bucketsNeeded = (((int) (Math.ceil((width * height) / areaPerBucket)) - extraBuckets));
        return Math.max(bucketsNeeded, 0);
    }
    public static int getBucketCount(double width, double height, double areaPerBucket) {
//        return((width <= 0) || (height <= 0) || (areaPerBucket <= 0)) ? -1 : (int) (Math.ceil((width * height) / areaPerBucket));
        return getBucketCount(width, height, areaPerBucket, 0);
    }
    public static int getBucketCount(double area, double areaPerBucket) {
//        return((area <= 0) || (areaPerBucket <= 0)) ? -1 : (int) (Math.ceil(area / areaPerBucket));
        return getBucketCount(area, 1, areaPerBucket, 0);
    }

    public static void main(String[] args) {
        System.out.println(getBucketCount(3.4, 2.1, 1.5, 2));
    }
}
