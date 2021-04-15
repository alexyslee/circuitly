package circuitly;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class createChip {
    eventHandling handled = new eventHandling();
    ImageView iv = new ImageView();
    
    public class createAndChip{
        public ImageView createShape(){
            Image test = new Image("file:images/AND.png");
            iv.setImage(test);
            iv.setX(300);
            iv.setY(5);
        
            iv.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){    
                createShape();  
            }
            });
        
            iv.setOnMouseDragged(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){    
                    iv.setX(e.getSceneX());
                    iv.setY(e.getSceneY());
                }
            });
        
            iv.setOnMouseReleased(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){
                    iv.setX(handled.lineUpChipX((int)e.getSceneX()));
                    iv.setY(handled.lineUpChipY((int)e.getSceneY()));
                }
            });
            
            return iv;
        }
        
        public String chipType(){
            String chipName = "and";
            return chipName;
        }
        
        public Double getX(){
            return iv.getX();
        }
        
    }
    
    public class createNandChip{
        public ImageView createShape(){
            Image test = new Image("file:images/NAND.png");
            iv.setImage(test);
            iv.setX(300);
            iv.setY(50);
        
            iv.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){    
                createShape();  
            }
            });
        
            iv.setOnMouseDragged(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){    
                    iv.setX(e.getSceneX());
                    iv.setY(e.getSceneY());
                }
            });
        
            iv.setOnMouseReleased(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){
                    iv.setX(handled.lineUpChipX((int)e.getSceneX()));
                    iv.setY(handled.lineUpChipY((int)e.getSceneY()));
                }
            });
            
            return iv;
        }
        
        public String chipType(){
            String chipName = "nand";
            return chipName;
        }
        
        public Double getX(){
            return iv.getX();
        }
        
    }
    
    public class createOrChip{
        public ImageView createShape(){
            Image test = new Image("file:images/OR.png");
            iv.setImage(test);
            iv.setX(405);
            iv.setY(5);
        
            iv.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){    
                createShape();  
            }
            });
        
            iv.setOnMouseDragged(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){    
                    iv.setX(e.getSceneX());
                    iv.setY(e.getSceneY());
                }
            });
        
            iv.setOnMouseReleased(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){
                    iv.setX(handled.lineUpChipX((int)e.getSceneX()));
                    iv.setY(handled.lineUpChipY((int)e.getSceneY()));
                }
            });
            
            return iv;
        }
        
        public String chipType(){
            String chipName = "or";
            return chipName;
        }
        
        public Double getX(){
            return iv.getX();
        }
        
    }
    
    public class createXorChip{
        public ImageView createShape(){
            Image test = new Image("file:images/XOR.png");
            iv.setImage(test);
            iv.setX(405);
            iv.setY(50);
        
            iv.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){    
                createShape();  
            }
            });
        
            iv.setOnMouseDragged(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){    
                    iv.setX(e.getSceneX());
                    iv.setY(e.getSceneY());
                }
            });
        
            iv.setOnMouseReleased(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){
                    iv.setX(handled.lineUpChipX((int)e.getSceneX()));
                    iv.setY(handled.lineUpChipY((int)e.getSceneY()));
                }
            });
            
            return iv;
        }
        
        public String chipType(){
            String chipName = "xor";
            return chipName;
        }
        
        public Double getX(){
            return iv.getX();
        }
        
    }
    
    public class createNorChip{
        public ImageView createShape(){
            Image test = new Image("file:images/NOR.png");
            iv.setImage(test);
            iv.setX(510);
            iv.setY(5);
        
            iv.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){    
                createShape();  
            }
            });
        
            iv.setOnMouseDragged(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){    
                    iv.setX(e.getSceneX());
                    iv.setY(e.getSceneY());
                }
            });
        
            iv.setOnMouseReleased(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){
                    iv.setX(handled.lineUpChipX((int)e.getSceneX()));
                    iv.setY(handled.lineUpChipY((int)e.getSceneY()));
                }
            });
            
            return iv;
        }
        
        public String chipType(){
            String chipName = "nor";
            return chipName;
        }
        
        public Double getX(){
            return iv.getX();
        }
        
    }
    
    public class createAndFourChip{
        public ImageView createShape(){
            Image test = new Image("file:images/ANDFOUR.png");
            iv.setImage(test);
            iv.setX(510);
            iv.setY(50);
        
            iv.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){    
                createShape();  
            }
            });
        
            iv.setOnMouseDragged(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){    
                    iv.setX(e.getSceneX());
                    iv.setY(e.getSceneY());
                }
            });
        
            iv.setOnMouseReleased(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){
                    iv.setX(handled.lineUpChipX((int)e.getSceneX()));
                    iv.setY(handled.lineUpChipY((int)e.getSceneY()));
                }
            });
            
            return iv;
        }
        
        public String chipType(){
            String chipName = "nor";
            return chipName;
        }
        
        public Double getX(){
            return iv.getX();
        }
        
    }
    
    public class createNandFourChip{
        public ImageView createShape(){
            Image test = new Image("file:images/NANDFOUR.png");
            iv.setImage(test);
            iv.setX(615);
            iv.setY(5);
        
            iv.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){    
                createShape();  
            }
            });
        
            iv.setOnMouseDragged(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){    
                    iv.setX(e.getSceneX());
                    iv.setY(e.getSceneY());
                }
            });
        
            iv.setOnMouseReleased(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){
                    iv.setX(handled.lineUpChipX((int)e.getSceneX()));
                    iv.setY(handled.lineUpChipY((int)e.getSceneY()));
                }
            });
            
            return iv;
        }
        
        public String chipType(){
            String chipName = "nor";
            return chipName;
        }
        
        public Double getX(){
            return iv.getX();
        }
        
    }
    
    public class createNotChip{
        public ImageView createShape(){
            Image test = new Image("file:images/NOT.png");
            iv.setImage(test);
            iv.setX(615);
            iv.setY(50);
        
            iv.setOnMousePressed(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){    
                createShape();  
            }
            });
        
            iv.setOnMouseDragged(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){    
                    iv.setX(e.getSceneX());
                    iv.setY(e.getSceneY());
                }
            });
        
            iv.setOnMouseReleased(new EventHandler<MouseEvent>(){
                public void handle(MouseEvent e){
                    iv.setX(handled.lineUpChipX((int)e.getSceneX()));
                    iv.setY(handled.lineUpChipY((int)e.getSceneY()));
                }
            });
            
            return iv;
        }
        
        public String chipType(){
            String chipName = "nor";
            return chipName;
        }
        
        public Double getX(){
            return iv.getX();
        }
        
    }
}
