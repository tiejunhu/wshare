(ns rtc.core)

(defn create-peer-connection []
  (new js/RTCPeerConnection))

(defn create-data-channel [conn chan-name]
  (let [chan (.createDataChannel conn chan-name)]
    (set! (.-binaryType chan) "arraybuffer")
    chan))
