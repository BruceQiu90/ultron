package io.bruce.ultron.manage.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.bruce.ultron.manage.bean.Project;
import io.bruce.ultron.manage.service.impl.ProjectServiceImpl;
import io.bruce.ultron.manage.web.BaseResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectControllerTest  {

    @Autowired
    private ObjectMapper mapper;

    @Mock
    private ProjectServiceImpl projectService;

    @Autowired
    @InjectMocks
    private ProjectController projectController;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();
    }

    @Test
    public void save() throws Exception {
        Project project = new Project();
        project.setProjectName("blink project");
        project.setDescription("realtime stream");
        String json = mapper.writeValueAsString(project);
        mockMvc.perform(post("/project").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(mapper.writeValueAsString(BaseResponse.success())));
    }

    @Test
    public void getById() throws Exception {
        Project project = new Project();
        project.setId(1L);
        project.setProjectName("blink project");
        project.setDescription("realtime stream");

        when(projectService.getById(1L)).thenReturn(project);

        mockMvc.perform(get("/project/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(mapper.writeValueAsString(BaseResponse.success(project))));
    }

    @Test
    public void updateById() throws Exception {
        Project project = new Project();

        doNothing().when(projectService).updateById(project);

        mockMvc.perform(put("/project/1")
                .contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(project)))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(mapper.writeValueAsString(BaseResponse.success())));
    }

    @Test
    public void deleteById() throws Exception {

        doNothing().when(projectService).deleteById(1L);

        mockMvc.perform(delete("/project/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().string(mapper.writeValueAsString(BaseResponse.success())));
    }

}