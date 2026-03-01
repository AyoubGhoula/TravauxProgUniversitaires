import { Directive, ElementRef, Input, OnChanges, SimpleChanges } from '@angular/core';

@Directive({
  selector: '[appHighlightStatus]',
  standalone: true,
})
export class HighlightStatusDirective implements OnChanges {
  @Input() appHighlightStatus: string = '';

  constructor(private el: ElementRef) {}

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['appHighlightStatus']) {
      this.applyHighlight();
    }
  }

  private applyHighlight(): void {
    switch (this.appHighlightStatus) {
      case 'En attente':
        this.el.nativeElement.style.backgroundColor = '#fef3c7'; 
        this.el.nativeElement.style.borderLeftColor = '#f59e0b'; 
        break;
      case 'En cours':
        this.el.nativeElement.style.backgroundColor = '#e0f2fe'; 
        this.el.nativeElement.style.borderLeftColor = '#0ea5e9'; 
        break;
      case 'Terminé':
        this.el.nativeElement.style.backgroundColor = '#dcfce7'; 
        this.el.nativeElement.style.borderLeftColor = '#22c55e'; 
        break;
      default:
        this.el.nativeElement.style.backgroundColor = '#f1f5f9'; 
        this.el.nativeElement.style.borderLeftColor = '#94a3b8'; 
        break;
    }
  }
}
