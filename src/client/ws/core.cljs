(ns ws.core
  (:require
   [taoensso.sente :as sente]))

(def ?csrf-token
  (when-let [el (.getElementById js/document "__anti-forgery-token")]
    (.getAttribute el "data-csrf-token")))

(defn make-ws-client []
  (sente/make-channel-socket-client! "/chsk" ?csrf-token {:type }))
