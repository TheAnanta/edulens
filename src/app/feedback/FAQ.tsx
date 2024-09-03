import { Button } from "@mui/material";
import React from "react";

export default function FAQ() {
  return (
    <div className="p-8 bg-[var(--secondary-color)] rounded-2xl">
      <div className="flex items-center justify-between w-full">
        <h1 className="text-xl font-semibold mb-4">Feedback Forms</h1>
        <span className="material-symbols-outlined">north_east</span>
      </div>
      <p className="mb-4">
        Lorem ipsum dolor, sit amet consectetur adipisicing elit. Mollitia nam
        nostrum ea. Quia error nihil delectus quibusdam id in distinctio neque
        quis corrupti! Doloremque impedit, et facere eligendi eum nihil!{" "}
      </p>
      <Button variant="contained">Submit Feedback</Button>
    </div>
  );
}
