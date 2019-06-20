package task9.wedCommand;

import com.epam.poliak.utils.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface WebCommand {

    String doCommand(String request);

    default int extractProductId(String request) {
        Matcher matcher = Pattern.compile(Constants.GET_ITEM_REQUEST_REGEXP).matcher(request);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        }
        return 0;
    }

}
