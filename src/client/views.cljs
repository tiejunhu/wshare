(ns views
  (:require
   [re-frame.core :as re-frame]
   [subs]
   [reagent.core :as reagent]))

(defn main []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:p @name]]))

(defn main-panel []
  [:<>
   [:> (reagent/reactify-component main)]])
