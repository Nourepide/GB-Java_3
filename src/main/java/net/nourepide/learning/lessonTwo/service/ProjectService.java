package net.nourepide.learning.lessonTwo.service;

import net.nourepide.learning.lessonTwo.enity.Project;
import net.nourepide.learning.lessonTwo.repository.ProjectRepository;

import java.io.IOException;
import java.util.List;

public final class ProjectService extends AbstractService {
    private final ProjectRepository projectRepository;

    public ProjectService() throws IOException {
        projectRepository = sqlSession.getMapper(ProjectRepository.class);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public List<String> ids() {
        return projectRepository.ids();
    }

    public Project findOne(String id) {
        return projectRepository.findOne(id);
    }

    public void insert(Project project) {
        projectRepository.insert(project);
    }

    public void update(Project project) {
        projectRepository.update(project);
    }

    public void clear() {
        projectRepository.clear();
    }
}
