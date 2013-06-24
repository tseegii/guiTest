package controller;

import org.zkoss.zk.ui.ext.AfterCompose;
import org.zkoss.zkplus.databind.AnnotateDataBinder;

/**
 * Created with IntelliJ IDEA.
 * User: tseegii
 * Date: 6/5/13
 * Time: 10:07 PM
 */
public interface BaseComponent extends AfterCompose{

    public AnnotateDataBinder getBinder();
}
