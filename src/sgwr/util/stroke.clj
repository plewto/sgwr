(ns sgwr.util.stroke
  (:require [sgwr.constants :as constants])
  (:require [sgwr.util.utilities :as utilities])
  (:require [seesaw.graphics :as ssg]))

(defn- stroke-style [n]
  (int (or (and (number? n) n)
           (get constants/line-styles n 0))))

(defn- get-dash-pattern [sty]
  (get constants/dash-patterns sty [1.0]))

(def default-stroke (ssg/stroke :dashes [1.0] :width 1.0))

(defn stroke [el]
  (cond (utilities/is-point? el) default-stroke
        (utilities/is-image? el) default-stroke
        (utilities/is-text? el)  default-stroke
        :default (let [sty (.style el)
                       dashpat (get constants/dash-patterns sty [1.0])
                       w (float (max 0.1 (.width el)))]
                   (ssg/stroke :dashes dashpat :width w))))
                       
        
  


           
