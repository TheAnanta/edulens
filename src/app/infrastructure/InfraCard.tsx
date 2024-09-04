import { Button } from "@mui/material";
import { Prosto_One } from "next/font/google";
import React from "react";

export default function InfraCard(props: { title: string; image: string }) {
  return (
    <div className="p-8 bg-[var(--secondary-color)] rounded-2xl">
      <h1 className="mb-4 font-bold text-2xl">{props.title}</h1>
      <img src={props.image} alt="" className="w-full h-80 object-cover mb-4 rounded-xl" />
      <p className="font-light mb-4">
        Lorem ipsum, dolor sit amet consectetur adipisicing elit. Consequatur
        quo voluptate quae ex, quod temporibus incidunt? At fugiat id deleniti.
        Nostrum doloribus voluptates veritatis reprehenderit possimus eius non,
        assumenda ad!
      </p>
      <Button variant="outlined">View</Button>
    </div>
  );
}
