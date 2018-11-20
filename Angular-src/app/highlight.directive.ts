import { Directive, ElementRef, HostListener, Input } from '@angular/core';
@Directive({
  selector: '[highlight]'
})
export class HighlightDirective {
  
  @Input("highlight") // input color for highlight directive
  color:string
  
  constructor(private currentElement:ElementRef) {
      this.color="yellow"
   }

   private applyHighlight(color:string){
     this.currentElement.nativeElement.style.backgroundColor=color
   }

   @HostListener("mouseenter")
    onMouseoverElement(){
      this.applyHighlight(this.color) // apply given color
    }

    @HostListener("mouseleave")
    onMouseoutElement(){
      this.applyHighlight(null) // remove the highlight
    }
}
