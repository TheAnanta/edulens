import { Button } from "@mui/material";
import React from "react";

export default function ResourceCard() {
  return (
    <div className="rounded-2xl bg-[var(--secondary-color)]  p-8">
      <h1 className="mb-4 font-semibold">DBMS</h1>
      <p className="mb-4">
        Lorem ipsum dolor sit amet consectetur adipisicing elit. Illo dicta ut
        quis veniam saepe nisi nulla. Temporibus excepturi voluptatem, commodi
        vel blanditiis recusandae facilis, amet, aliquid sunt libero fugit vero!
      </p>
      <div className="w-full flex items-start justify-start space-x-4">
        <Button variant="outlined">Outlined</Button>
        <Button variant="contained">Outlined</Button>
      </div>
    </div>
  );
}
