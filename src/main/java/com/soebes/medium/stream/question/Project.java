package com.soebes.medium.stream.question;

public class Project {

  private String name;
  private String team;
  private String projectManager;

  public Project(String name, String team, String projectManager) {
    this.name = name;
    this.team = team;
    this.projectManager = projectManager;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTeam() {
    return team;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  public String getProjectManager() {
    return projectManager;
  }

  public void setProjectManager(String projectManager) {
    this.projectManager = projectManager;
  }
}
