(ns rtc.core
  (:require
   [cljs.core.async :as a]
   [cljs.core.async.interop :refer-macros [<p!]]))

(defn create-peer-connection []
  (new js/RTCPeerConnection))

(defn make-data-channel [conn chan-name]
  (let [chan (.createDataChannel conn chan-name)]
    (set! (.-binaryType chan) "arraybuffer")
    chan))

(defn make-offer [conn]
  (a/go
    (let [offer (<p! (.createOffer conn))]
      (<p! (.setLocalDescription conn offer))
      (.-localDescription conn))))

(defn test-rtc []
  (a/go
    (let [conn (create-peer-connection)
          offer (a/<! (make-offer conn))]
      (.log js/console offer))))
