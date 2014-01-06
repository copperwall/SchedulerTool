import java.awt.Color;


class Cell {
   public Color backgroundColor;
   public String value;
   public Color changeColor;
   
   
   public Cell(Color changeColor) {
      this.value = null;
      this.changeColor = changeColor;
   }
   
   public Cell(String t, Color changeColor) {
      this.value = t;
   }

   public boolean isColorable() {
      return value == null;
   }
   
   public boolean backgroundIsSet() {
      return backgroundColor != null && backgroundColor == changeColor;
   }
   
   @Override
   public String toString() {
      return value == null ? "" : value;
   }
}
