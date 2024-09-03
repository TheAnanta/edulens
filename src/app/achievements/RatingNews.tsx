import React from "react";

export default function RatingNews() {
  return (
    <div className="p-4 bg-[var(--secondary-color)] rounded-xl">
      <div className="flex justify-between mb-2">
        <h1 className="font-semibold">EduLens University</h1>
        <button className="bg-[var(--main-color)] text-white rounded-full px-4 py-2 mt-4">
          View
        </button>
      </div>
      <h3 className="my-2 text-xl">NAAC A++ Rating</h3>
      <p>
        Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
        tempor
      </p>
    </div>
  );
}
