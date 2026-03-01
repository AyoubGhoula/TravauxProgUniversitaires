import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HighlightStatusDirective } from '../../directives/highlight-status.directive';
import { PriorityColorPipe } from '../../pipes/priority-color.pipe';

interface Task {
  title: string;
  priority: string;
  status: string;
}

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [CommonModule, HighlightStatusDirective, PriorityColorPipe],
  templateUrl: './task-list.html',
})
export class TaskList {

  @Input() tasks: Task[] = [];
  @Output() statusChanged = new EventEmitter<{ task: Task; newStatus: string }>();
  @Output() taskDeleted = new EventEmitter<Task>();

  private statusFlow = ['En attente', 'En cours', 'Terminé'];

  nextStatus(task: Task): void {
    const currentIndex = this.statusFlow.indexOf(task.status);
    const nextIndex = (currentIndex + 1) % this.statusFlow.length;
    this.statusChanged.emit({ task, newStatus: this.statusFlow[nextIndex] });
  }

  deleteTask(task: Task): void {
    this.taskDeleted.emit(task);
  }

  getNextStatusLabel(status: string): string {
    const currentIndex = this.statusFlow.indexOf(status);
    const nextIndex = (currentIndex + 1) % this.statusFlow.length;
    return this.statusFlow[nextIndex];
  }

  getStatusColor(status: string) {
    switch (status) {
      case 'En attente':
        return 'border-yellow-500';
      case 'En cours':
        return 'border-cyan-500';
      case 'Terminé':
        return 'border-green-500';
      default:
        return 'border-gray-300';
    }
  }

  getBGStatusColor(status: string) {
    switch (status) {
      case 'En attente':
        return 'bg-amber-200'; 
      case 'En cours':
        return 'bg-sky-200';
      case 'Terminé':
        return 'bg-green-200';
      default:
        return 'bg-gray-200';
    }
  }
}

 

