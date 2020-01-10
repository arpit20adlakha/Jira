package Constants;

import java.util.HashMap;
import java.util.Map;

public interface Constants {

    enum Status {
        INPROGRESS(1),
        TODO(2),
        BACKLOG(3),
        REVIEW(4),
        CLOSED(5);



        private int value;
        private static Map map = new HashMap<>();

        private Status(int value) {
            this.value = value;
        }

        static {
            for (Status status : Status.values()) {
                map.put(status.value, status);
            }
        }

        public static Status valueOf(int status) {
            return (Status) map.get(status);
        }

        public int getValue() {
            return value;
        }
    }

    enum Type {
        BUG(1),
        STORY(2),
        EPIC(3),
        TASK(4);

        private int value;
        private static Map map = new HashMap<>();

        private Type(int value) {
            this.value = value;
        }

        static {
            for (Type type : Type.values()) {
                map.put(type.value, type);
            }
        }

        public static Type valueOf(int type) {
            return (Type) map.get(type);
        }

        public int getValue() {
            return value;
        }
    }


}
