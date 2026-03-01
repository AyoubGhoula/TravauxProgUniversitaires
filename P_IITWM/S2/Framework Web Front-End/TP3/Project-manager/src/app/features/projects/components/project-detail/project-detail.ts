import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TaskList } from '../task-list/task-list';

interface Task {
  title: string;
  priority: string;
  status: string;
}

interface Project {
  name: string;
  description: string;
  status: string;
  tasks: Task[];
}

@Component({
  selector: 'app-project-detail',
  standalone: true,
  imports: [CommonModule, FormsModule, TaskList],
  templateUrl: './project-detail.html',
  styleUrl: './project-detail.css',
})
export class ProjectDetail {
  @Input() project!: Project;

  // Formulaire d'ajout de tâche
  showAddForm = false;
  newTaskTitle = '';
  newTaskPriority = 'Moyenne';

  getProgress(): number {
    if (!this.project || !this.project.tasks || this.project.tasks.length === 0) {
      return 0;
    }
    return (
      (this.project.tasks.filter((t) => t.status === 'Terminé').length /
        this.project.tasks.length) *
      100
    );
  }

  addTask(): void {
    if (!this.newTaskTitle.trim()) return;
    this.project.tasks.push({
      title: this.newTaskTitle.trim(),
      priority: this.newTaskPriority,
      status: 'En attente',
    });
    this.newTaskTitle = '';
    this.newTaskPriority = 'Moyenne';
    this.showAddForm = false;
  }

  onStatusChanged(event: { task: Task; newStatus: string }): void {
    event.task.status = event.newStatus;
  }

  onTaskDeleted(task: Task): void {
    const index = this.project.tasks.indexOf(task);
    if (index > -1) {
      this.project.tasks.splice(index, 1);
    }
  }
}
