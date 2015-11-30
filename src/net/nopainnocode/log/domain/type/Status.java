package net.nopainnocode.log.domain.type;

/**
 * Created by no_pain_no_code on 2015. 11. 29..
 */
public enum Status {

    ERROR(10), OK(200), NOTFOUND(404);

    private int value;

    Status(int value) {
        this.value = value;
    }

    public static Status valueOf(int value) {
        switch(value) {
            case 10 : return ERROR;
            case 200 : return OK;
            case 404 : return NOTFOUND;
        }

        return null;
    }
}
