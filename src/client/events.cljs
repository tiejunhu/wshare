(ns events
  (:require
   [re-frame.core :as re-frame]
   [db]))

(re-frame/reg-event-db
 ::initialize-db
 (fn []
   db/default-db))

(re-frame/reg-event-db
 ::button-click
 (fn [db]
   (assoc-in db [:name] "new name")))

(re-frame/reg-event-db
 ::button-perferences-click
 (fn [db]
   (assoc-in db [:name] "new name")))
