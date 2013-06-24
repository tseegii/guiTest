package controller;

import org.zkoss.zkplus.databind.AnnotateDataBinder;
import org.zkoss.zul.Panel;

/**
 * Created with IntelliJ IDEA.
 * User: tseegii
 * Date: 6/5/13
 * Time: 10:06 PM
 */
public class BasePanel extends Panel implements BaseComponent {

    /**
     * ZUL file-дээр хэрэв DataBinder ашиглаж байгаа бол
     * үүнийг ашиглаж мэдээллийг zul файл-руу илгээнэ.
     */
    private AnnotateDataBinder binder = null;

    @Override
    public AnnotateDataBinder getBinder() {
        return binder;
    }

    @Override
    public void afterCompose() {
        BaseConvention.processRecursive(this, this, this);
        try {
            binder = BaseConvention.getDataBinder(this, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}