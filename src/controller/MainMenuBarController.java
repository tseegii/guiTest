package controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zul.Include;
import org.zkoss.zul.Toolbar;
import org.zkoss.zul.Toolbarbutton;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: tseegii
 * Date: 6/5/13
 * Time: 10:00 PM
 */
public class MainMenuBarController extends SelectorComposer<Component> {

    HashMap<String, String> windowsPath = new HashMap<String, String>();
    ArrayList<Toolbarbutton> toolbarButtons = null;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        initToolbarButtons();
        initMap();
        Toolbar toolbar = (Toolbar) comp;
        for (Toolbarbutton toolbarbutton : toolbarButtons) {
            toolbar.appendChild(toolbarbutton);
            toolbarbutton.addEventListener(Events.ON_CLICK, listener());
        }
        super.doAfterCompose(comp);
    }

    private void initMap() {
        windowsPath.put("employee", "EmployeePanel");
        windowsPath.put("position", "");
        windowsPath.put("request", "RequestHRPanel");
        windowsPath.put("overtime", "OvertimePanel");
        windowsPath.put("leave", "LeaveHRPanel");
        windowsPath.put("probation", "ProbationHRPanel");
        windowsPath.put("resume", "ResumeHRPanel");
        windowsPath.put("notification", "");
        windowsPath.put("changePassword", "");
        windowsPath.put("logout", "");
    }

    private void initToolbarButtons() {
        toolbarButtons = new ArrayList<Toolbarbutton>();
        Toolbarbutton toolbarbutton = new Toolbarbutton("Ажилчид");
        toolbarbutton.setId("employee");
        toolbarButtons.add(toolbarbutton);
        toolbarbutton = new Toolbarbutton("Хүсэлт");
        toolbarbutton.setId("request");
        toolbarButtons.add(toolbarbutton);
        toolbarbutton = new Toolbarbutton("Албан тушаал");
        toolbarbutton.setId("position");
        toolbarButtons.add(toolbarbutton);
        toolbarbutton = new Toolbarbutton("Илүү цаг");
        toolbarbutton.setId("overtime");
        toolbarButtons.add(toolbarbutton);
        toolbarbutton = new Toolbarbutton("Чөлөө");
        toolbarbutton.setId("leave");
        toolbarButtons.add(toolbarbutton);
        toolbarbutton = new Toolbarbutton("Шийтгэл");
        toolbarbutton.setId("probation");
        toolbarButtons.add(toolbarbutton);
        toolbarbutton = new Toolbarbutton("Ажилд орох хүсэлт");
        toolbarbutton.setId("resume");
        toolbarButtons.add(toolbarbutton);
        toolbarbutton = new Toolbarbutton("notification");
        toolbarbutton.setId("notification");
        toolbarButtons.add(toolbarbutton);
        toolbarbutton = new Toolbarbutton("Нууц үг солих");
        toolbarbutton.setId("changePassword");
        toolbarButtons.add(toolbarbutton);
        toolbarbutton = new Toolbarbutton("Гарах");
        toolbarbutton.setId("logout");
        toolbarbutton.setStyle("float:right;");
        toolbarButtons.add(toolbarbutton);
    }

    private EventListener<? extends Event> listener() {
        return new EventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                changeComponent(event.getTarget().getId());
            }
        };
    }

//    @Listen("onClick = #employee")
//    public void empClick() {
//        centerInclude.setSrc("EmployeePanel.zul");
//        Messagebox.show("it worked " + mainComponent);
//    }

    public void changeComponent(String componentId) {
//        Messagebox.show("it worked " + );
        Include include= (Include) this.getSelf().getParent().getRoot().getFellow("centerInclude");
        include.setSrc(windowsPath.get(componentId)+".zul");
    }
}
