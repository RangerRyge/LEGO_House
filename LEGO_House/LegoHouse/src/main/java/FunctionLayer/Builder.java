package FunctionLayer;

import java.util.HashMap;

public class Builder {

    private static Builder singleton;

    public static Builder Calculator() {
        if (singleton == null) {
            singleton = new Builder();
        }
        return singleton;
    }

    HashMap<String, Integer> counter;

    public HashMap<String, Integer> calculateHouse(HashMap<String, Integer> counter, int length, int width, int height) throws BuilderException {
        this.counter = counter;
        calHeight(height, length, width);
        return this.counter;
    }

    private void calHeight(int height, int length, int width) throws BuilderException {
        for (int i = 1; i <= height; i++) {
            if (i < 4) {
                calDoorAndWindow(i, length, width);
            } else {
                if (i % 2 == 0) {
                    calLengthShort(length - 4);
                    calWidthShort(width);
                } else {
                    calLength(length);
                    calWidth(width - 4);

                }

            }

        }
    }

    private void calDoorAndWindow(int i, int length, int width) throws BuilderException {
        switch (i) {
            case 1:
                calLength(length);
                calLengthShort(length);
                calWidth(width - 4);
                calculateLengthWithDoor(length, 0);
                break;
            case 2:
                calWidth(width);
                calWidthShort(width);
                calculateLengthWithWindow(length - 4, 2);
                calculateLengthWithDoor(length - 4, 2);
                break;
            case 3:
                calculateLengthWithWindow(length, 0);
                calWidth(width - 4);
                calculateLengthWithDoor(length, 0);
                break;
            default:
                throw new BuilderException("Could not plan Door or Window, try again.");
        }
    }

    private void calWidth(int width) {

        for (int i = 0; i < width;) {
            if (i + 4 <= width) {
                int oldCount = counter.get("4x2");
                counter.put("4x2", ++oldCount);
                i += 4;
            } else if (i + 2 <= width) {
                int oldCount = counter.get("2x2");
                counter.put("2x2", ++oldCount);
                i += 2;
            } else if (i + 1 <= width) {
                int oldCount = counter.get("1x2");
                counter.put("1x2", ++oldCount);
                i += 1;

            }
        }
    }

    private void calWidthShort(int width) {

        for (int i = 0; i < width;) {
            if (i + 2 <= width) {
                int oldCount = counter.get("2x2");
                counter.put("2x2", ++oldCount);
                i += 2;
            } else if (i + 1 <= width) {
                int oldCount = counter.get("1x2");
                counter.put("1x2", ++oldCount);
                i += 1;

            }
        }
    }

    private boolean makeRoomForWindow(int i, int number, int minus) {
        return i + number != 5 - minus && i + number != 6 - minus && i != 5 - minus && i != 6 - minus;
    }

    private boolean makeRoomForDoor(int i, int number, int minus) {
        return makeRoomForWindow(i, number, minus) && i + number != 7 - minus && i + number != 8 - minus && i != 7 - minus && i != 8 - minus;
    }

    private void calculateLengthWithWindow(int length, int minus) {
        for (int i = 0; i < length;) {
            if (i + 4 <= length && makeRoomForWindow(i, 4, minus)) {
                int oldVal = counter.get("4x2");
                counter.put("4x2", ++oldVal);
                i += 4;
            } else if (i + 2 <= length && makeRoomForWindow(i, 2, minus)) {
                int oldVal = counter.get("2x2");
                counter.put("2x2", ++oldVal);
                i += 2;
            } else if (i + 1 <= length && makeRoomForWindow(i, 1, minus)) {
                int oldVal = counter.get("1x2");
                counter.put("1x2", ++oldVal);
                i += 1;
            } else {
                i++; // Skip a step
            }
        }
    }

    private void calculateLengthWithDoor(int length, int minus) {
        for (int i = 0; i < length;) {
            if (i + 4 <= length && makeRoomForDoor(i, 4, minus)) {
                int oldVal = counter.get("4x2");
                counter.put("4x2", ++oldVal);
                i += 4;
            } else if (i + 2 <= length && makeRoomForDoor(i, 2, minus)) {
                int oldVal = counter.get("2x2");
                counter.put("2x2", ++oldVal);
                i += 2;
            } else if (i + 1 <= length && makeRoomForDoor(i, 1, minus)) {
                int oldVal = counter.get("1x2");
                counter.put("1x2", ++oldVal);
                i += 1;
            } else {
                i++; // Skip a step
            }
        }
    }

    private void calLength(int length) {

        for (int i = 0; i < length;) {
            if (i + 4 <= length) {
                int oldCount = counter.get("4x2");
                counter.put("4x2", ++oldCount);
                i += 4;
            } else if (i + 2 <= length) {
                int oldCount = counter.get("2x2");
                counter.put("2x2", ++oldCount);
                i += 2;
            } else if (i + 1 <= length) {
                int oldCount = counter.get("1x2");
                counter.put("1x2", ++oldCount);
                i += 1;

            }
        }
    }

    private void calLengthShort(int length) {

        for (int i = 0; i < length;) {
            if (i + 2 <= length) {
                int oldCount = counter.get("2x2");
                counter.put("2x2", ++oldCount);
                i += 2;
            } else if (i + 1 <= length) {
                int oldCount = counter.get("1x2");
                counter.put("1x2", ++oldCount);
                i += 1;

            }
        }
    }
}
