package com.amverhagen.web.programmers.frontend;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.amverhagen.web.programmers.backend.entities.Programmer;
import com.amverhagen.web.programmers.backend.services.ProgrammerServices;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Grid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
public class MyUI extends UI {

	private static final long serialVersionUID = 1L;
	private final VerticalLayout verticalLayout = new VerticalLayout();
	private final Grid programmerGrid = new Grid();

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		verticalLayout.addComponent(programmerGrid);
		this.updateGrid();
		this.setContent(verticalLayout);
	}

	private void updateGrid() {
		List<Programmer> programmers = ProgrammerServices.getProgrammers();
		programmerGrid.setContainerDataSource(new BeanItemContainer<>(Programmer.class, programmers));
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
		private static final long serialVersionUID = 1L;
	}
}
