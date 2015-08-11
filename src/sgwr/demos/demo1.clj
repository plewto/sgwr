(ns sgwr.demos.demo1
  (:require [sgwr.components.drawing :as drawing])
  (:require [sgwr.components.line :as line])
  (:require [seesaw.core :as ss])
)

(defn demo1 []
  (let [drw (drawing/native-drawing 600 400)
        root (.root drw)
        l1 (line/line root [100 100] [300 300] :color :red)
        f (ss/frame :title "Sgwr Demo 1"
                    :content (.canvas drw)
                    :on-close :dispose
                    :size [640 :by 440])]
    (.render drw)
    (ss/show! f)))
    
