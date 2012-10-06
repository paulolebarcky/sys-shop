package sys.shop.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author paulo
 */
public class DateUtil {
    
    public static final Logger logger = Logger.getLogger(DateUtil.class.getName());

    public static final String DATE_FORMAT = "dd/MM/yyyy";

    public static String formatDate(Date date) {
        String dateStr = "";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
            dateStr = simpleDateFormat.format(date).toString();

        } catch (Exception e) {
            logger.warning("Erro ao formatar data.");
        }

        return dateStr;
    }
}
