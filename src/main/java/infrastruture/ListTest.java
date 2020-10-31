package infrastruture;

import java.util.ArrayList;
import java.util.List;

import infrastruture.data.ErrorCodesMessage;
import infrastruture.exception.BusinessException;

public class ListTest {
    public static void main(String[] args) {
        System.out.println(listString());
    }

    private static List<String> listString() {
        List<String> list = new ArrayList<>();

        if (null == list || list.isEmpty())
            throw new BusinessException(ErrorCodesMessage.EASTER_EGG_NOT_FOUND);
        return list;
    }
}
