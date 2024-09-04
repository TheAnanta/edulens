export default function Card(props: { title: string; attribute: any }) {
  return (
    <div className="bg-[var(--secondary-color)] p-6 w-full rounded-3xl flex items-center justify-between space-x-6">
      <div className="font-semibold">
        {props.title}
      </div>
      <p>{props.attribute}</p>
    </div>
  );
}
