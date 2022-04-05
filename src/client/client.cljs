(ns client
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as re-frame]
   [rtc.core :as rtc]
   [events]
   [views]))

(def debug?
  "^boolean用于提示编译器，可在goog.DEBUG=false时消除代码"
  ^boolean goog.DEBUG)

(defn dev-setup []
  (when debug?
    (println "dev mode")))

(defn ^:dev/after-load mount-root
  "给mount-root函数加一个:dev/after-load的meta，这样在开发模式下，reload之后，会自动执行"
  []
  (re-frame/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [views/main-panel] root-el)))

(defn main []
  (rtc/test-rtc)
  ;; 这个事件要同步分发，这样才能保证db在所有的其它事件之前初始化完
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
